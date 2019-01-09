

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Product.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'


const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(product)=>{return [
	 ]}

const internalImageListOf = (product) =>defaultImageListOf(product,imageList)

const optionList =(product)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (product) =>defaultSettingListOf(product, optionList)
const internalLargeTextOf = (product) =>{

	return(<div> 
   <Card title={`Remark`} ><pre>{product.remark}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (product,targetComponent) =>{
	
	
	const {ProductService} = GlobalComponents
	
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{product.id}</Description> 
<Description term="Name">{product.name}</Description> 
<Description term="Parent Category">{product.parentCategory==null?"未分配":product.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelNCategory",ProductService.requestCandidateParentCategory,
	      ProductService.transferToAnotherParentCategory,"anotherParentCategoryId",product.parentCategory?product.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Origin">{product.origin}</Description> 
<Description term="Catalog">{product.catalog==null?"未分配":product.catalog.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Catalog","catalog",ProductService.requestCandidateCatalog,
	      ProductService.transferToAnotherCatalog,"anotherCatalogId",product.catalog?product.catalog.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{product.lastUpdateTime}</Description> 
	
        {buildTransferModal(product,targetComponent)}
      </DescriptionList>
	)

}


class ProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"城市",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'product'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, productRecommendationListMetaInfo, skuListMetaInfo, productRecommendationCount, skuCount } = this.props.product
    if(!this.props.product.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Product",cardsFor: "product",
    	cardsSource: this.props.product,returnURL,displayName,
  		subItems: [
{name: 'productRecommendationList', displayName:'Product Recommendation',type:'productRecommendation',count:productRecommendationCount,addFunction: true, role: 'productRecommendation', metaInfo: productRecommendationListMetaInfo},
{name: 'skuList', displayName:'Sku',type:'sku',count:skuCount,addFunction: true, role: 'sku', metaInfo: skuListMetaInfo},
    
      	],
  	};
    //下面各个渲染方法都可以定制，只要在每个模型的里面的_features="custom"就可以得到定制的例子
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  product: state._product,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(ProductDashboard))

