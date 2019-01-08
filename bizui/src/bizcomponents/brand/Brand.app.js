import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Brand.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class BrandBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
    // 把一级 Layout 的 children 作为菜单项
    // this.menus = getNavData().reduce((arr, current) => arr.concat(current.children), [])
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/brand/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/brand/${this.props.brand.id}/dashboard`}><Icon type="dashboard" /><span>仪表板</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>回到主页</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}列表`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/brand/${this.props.brand.id}/preference`}><Icon type="setting" /><span>设置</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getProductSearch = () => {
    const {ProductSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Product",
      role: "product",
      data: state._brand.productList,
      metaInfo: state._brand.productListMetaInfo,
      count: state._brand.productCount,
      currentPage: state._brand.productCurrentPageNumber,
      searchFormParameters: state._brand.productSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'productList', ref:state._brand, 
      listDisplayName: 'Product列表' }, // this is for model namespace and
    }))(ProductSearch)
  }
  getProductCreateForm = () => {
   	const {ProductCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "product",
      data: state._brand.productList,
      metaInfo: state._brand.productListMetaInfo,
      count: state._brand.productCount,
      currentPage: state._brand.productCurrentPageNumber,
      searchFormParameters: state._brand.productSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'productList', ref:state._brand, listDisplayName: 'Product列表'}, // this is for model namespace and
    }))(ProductCreateForm)
  }
  
  getProductUpdateForm = () => {
  	const {ProductUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "product",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'productList', ref:state._brand, listDisplayName: 'Product列表' }, // this is for model namespace and
    }))(ProductUpdateForm)
  }

  getProductRecommendationSearch = () => {
    const {ProductRecommendationSearch} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      name: "Product Recommendation",
      role: "productRecommendation",
      data: state._brand.productRecommendationList,
      metaInfo: state._brand.productRecommendationListMetaInfo,
      count: state._brand.productRecommendationCount,
      currentPage: state._brand.productRecommendationCurrentPageNumber,
      searchFormParameters: state._brand.productRecommendationSearchFormParameters,
      searchParameters: {...state._brand.searchParameters},
      expandForm: state._brand.expandForm,
      loading: state._brand.loading,
      partialList: state._brand.partialList,
      owner: { type: '_brand', id: state._brand.id, 
      referenceName: 'brand', 
      listName: 'productRecommendationList', ref:state._brand, 
      listDisplayName: 'Product Recommendation列表' }, // this is for model namespace and
    }))(ProductRecommendationSearch)
  }
  getProductRecommendationCreateForm = () => {
   	const {ProductRecommendationCreateForm} = GlobalComponents;
    return connect(state => ({
      rule: state.rule,
      role: "productRecommendation",
      data: state._brand.productRecommendationList,
      metaInfo: state._brand.productRecommendationListMetaInfo,
      count: state._brand.productRecommendationCount,
      currentPage: state._brand.productRecommendationCurrentPageNumber,
      searchFormParameters: state._brand.productRecommendationSearchFormParameters,
      loading: state._brand.loading,
      owner: { type: '_brand', id: state._brand.id, referenceName: 'brand', listName: 'productRecommendationList', ref:state._brand, listDisplayName: 'Product Recommendation列表'}, // this is for model namespace and
    }))(ProductRecommendationCreateForm)
  }
  
  getProductRecommendationUpdateForm = () => {
  	const {ProductRecommendationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._brand.selectedRows,
      role: "productRecommendation",
      currentUpdateIndex: state._brand.currentUpdateIndex,
      owner: { type: '_brand', id: state._brand.id, listName: 'productRecommendationList', ref:state._brand, listDisplayName: 'Product Recommendation列表' }, // this is for model namespace and
    }))(ProductRecommendationUpdateForm)
  }


  
  buildRouters = () =>{
  	const {BrandDashboard} = GlobalComponents
  	const {BrandPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/brand/:id/dashboard", component: BrandDashboard},
  	{path:"/brand/:id/preference", component: BrandPreference},
  	
  	
  	
  	{path:"/brand/:id/list/productList", component: this.getProductSearch()},
  	{path:"/brand/:id/list/productCreateForm", component: this.getProductCreateForm()},
  	{path:"/brand/:id/list/productUpdateForm", component: this.getProductUpdateForm()},
   	
  	{path:"/brand/:id/list/productRecommendationList", component: this.getProductRecommendationSearch()},
  	{path:"/brand/:id/list/productRecommendationCreateForm", component: this.getProductRecommendationCreateForm()},
  	{path:"/brand/:id/list/productRecommendationUpdateForm", component: this.getProductRecommendationUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'null'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props

     //const {BrandEditDetail} = GlobalComponents
     //const {BrandViewDetail} = GlobalComponents
     
     
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     
     
     // Don't show popup menu when it is been collapsed
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          退出</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.brand)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  brand: state._brand,
  ...state,
}))(BrandBizApp)



