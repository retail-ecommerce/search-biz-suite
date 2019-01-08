

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {PlatformBizApp} = GlobalComponents
	const {SiteBizApp} = GlobalComponents
	const {CatalogBizApp} = GlobalComponents
	const {LevelOneCategoryBizApp} = GlobalComponents
	const {LevelTwoCategoryBizApp} = GlobalComponents
	const {LevelNCategoryBizApp} = GlobalComponents
	const {BrandBizApp} = GlobalComponents
	const {ProductBizApp} = GlobalComponents
	const {ProductRecommendationBizApp} = GlobalComponents
	const {SkuBizApp} = GlobalComponents
	const {ProfileBizApp} = GlobalComponents
	const {ShippingAddressBizApp} = GlobalComponents
	const {PaymentMethodBizApp} = GlobalComponents
	const {UserOrderBizApp} = GlobalComponents
	const {LineItemBizApp} = GlobalComponents
	const {OrderPromotionBizApp} = GlobalComponents
	const {ManualAdjustmentBizApp} = GlobalComponents
	const {ShippingGroupBizApp} = GlobalComponents
	const {PaymentGroupBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/platform/" component={PlatformBizApp} />
          <Route path="/site/" component={SiteBizApp} />
          <Route path="/catalog/" component={CatalogBizApp} />
          <Route path="/levelOneCategory/" component={LevelOneCategoryBizApp} />
          <Route path="/levelTwoCategory/" component={LevelTwoCategoryBizApp} />
          <Route path="/levelNCategory/" component={LevelNCategoryBizApp} />
          <Route path="/brand/" component={BrandBizApp} />
          <Route path="/product/" component={ProductBizApp} />
          <Route path="/productRecommendation/" component={ProductRecommendationBizApp} />
          <Route path="/sku/" component={SkuBizApp} />
          <Route path="/profile/" component={ProfileBizApp} />
          <Route path="/shippingAddress/" component={ShippingAddressBizApp} />
          <Route path="/paymentMethod/" component={PaymentMethodBizApp} />
          <Route path="/userOrder/" component={UserOrderBizApp} />
          <Route path="/lineItem/" component={LineItemBizApp} />
          <Route path="/orderPromotion/" component={OrderPromotionBizApp} />
          <Route path="/manualAdjustment/" component={ManualAdjustmentBizApp} />
          <Route path="/shippingGroup/" component={ShippingGroupBizApp} />
          <Route path="/paymentGroup/" component={PaymentGroupBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










