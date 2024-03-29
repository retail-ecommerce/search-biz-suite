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
import styles from './Product.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

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




class ProductBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
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
      return ['/product/']
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
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/product/${this.props.product.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/product/${this.props.product.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getProductRecommendationSearch = () => {
    const {ProductRecommendationSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Product Recommendation",
      role: "productRecommendation",
      data: state._product.productRecommendationList,
      metaInfo: state._product.productRecommendationListMetaInfo,
      count: state._product.productRecommendationCount,
      currentPage: state._product.productRecommendationCurrentPageNumber,
      searchFormParameters: state._product.productRecommendationSearchFormParameters,
      searchParameters: {...state._product.searchParameters},
      expandForm: state._product.expandForm,
      loading: state._product.loading,
      partialList: state._product.partialList,
      owner: { type: '_product', id: state._product.id, 
      referenceName: 'product', 
      listName: 'productRecommendationList', ref:state._product, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductRecommendationSearch)
  }
  getProductRecommendationCreateForm = () => {
   	const {ProductRecommendationCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "productRecommendation",
      data: state._product.productRecommendationList,
      metaInfo: state._product.productRecommendationListMetaInfo,
      count: state._product.productRecommendationCount,
      currentPage: state._product.productRecommendationCurrentPageNumber,
      searchFormParameters: state._product.productRecommendationSearchFormParameters,
      loading: state._product.loading,
      owner: { type: '_product', id: state._product.id, referenceName: 'product', listName: 'productRecommendationList', ref:state._product, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProductRecommendationCreateForm)
  }
  
  getProductRecommendationUpdateForm = () => {
    const userContext = null
  	const {ProductRecommendationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._product.selectedRows,
      role: "productRecommendation",
      currentUpdateIndex: state._product.currentUpdateIndex,
      owner: { type: '_product', id: state._product.id, listName: 'productRecommendationList', ref:state._product, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProductRecommendationUpdateForm)
  }

  getSkuSearch = () => {
    const {SkuSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Sku",
      role: "sku",
      data: state._product.skuList,
      metaInfo: state._product.skuListMetaInfo,
      count: state._product.skuCount,
      currentPage: state._product.skuCurrentPageNumber,
      searchFormParameters: state._product.skuSearchFormParameters,
      searchParameters: {...state._product.searchParameters},
      expandForm: state._product.expandForm,
      loading: state._product.loading,
      partialList: state._product.partialList,
      owner: { type: '_product', id: state._product.id, 
      referenceName: 'product', 
      listName: 'skuList', ref:state._product, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SkuSearch)
  }
  getSkuCreateForm = () => {
   	const {SkuCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "sku",
      data: state._product.skuList,
      metaInfo: state._product.skuListMetaInfo,
      count: state._product.skuCount,
      currentPage: state._product.skuCurrentPageNumber,
      searchFormParameters: state._product.skuSearchFormParameters,
      loading: state._product.loading,
      owner: { type: '_product', id: state._product.id, referenceName: 'product', listName: 'skuList', ref:state._product, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(SkuCreateForm)
  }
  
  getSkuUpdateForm = () => {
    const userContext = null
  	const {SkuUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._product.selectedRows,
      role: "sku",
      currentUpdateIndex: state._product.currentUpdateIndex,
      owner: { type: '_product', id: state._product.id, listName: 'skuList', ref:state._product, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(SkuUpdateForm)
  }


  
  buildRouters = () =>{
  	const {ProductDashboard} = GlobalComponents
  	const {ProductPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/product/:id/dashboard", component: ProductDashboard},
  	{path:"/product/:id/preference", component: ProductPreference},
  	
  	
  	
  	{path:"/product/:id/list/productRecommendationList", component: this.getProductRecommendationSearch()},
  	{path:"/product/:id/list/productRecommendationCreateForm", component: this.getProductRecommendationCreateForm()},
  	{path:"/product/:id/list/productRecommendationUpdateForm", component: this.getProductRecommendationUpdateForm()},
   	
  	{path:"/product/:id/list/skuList", component: this.getSkuSearch()},
  	{path:"/product/:id/list/skuCreateForm", component: this.getSkuCreateForm()},
  	{path:"/product/:id/list/skuUpdateForm", component: this.getSkuUpdateForm()},
     	
  	
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
    const title = 'Search Services'
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
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
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
          {appLocaleName(userContext,"Exit")}</Button>
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

		 {this.getNavMenuItems(this.props.product)}
		 
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
  product: state._product,
  ...state,
}))(ProductBizApp)



