import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './UserOrder.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import UserOrderBase from './UserOrder.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: 'a consumer order',
  totalAdjustment: '87.55',
  totalAmount: '7135.88',
  lastUpdateTime: 'lastUpdateTime()',
  userId: 'P000001',
  platformId: 'P000001',
}
*/


const imageKeys = [
]


class UserOrderAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {UserOrderService} = GlobalComponents
 const {LineItemModalTable} = GlobalComponents;
 const {OrderPromotionModalTable} = GlobalComponents;
 const {ManualAdjustmentModalTable} = GlobalComponents;
 const {ShippingGroupModalTable} = GlobalComponents;
 const {PaymentGroupModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = UserOrderBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    
    return (
 <Modal
          title="创建新的支付"
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: '请输入Title' }],
                  })(
                    <Input placeholder="请输入Title" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.totalAdjustment} {...formItemLayout}>
                  {getFieldDecorator('totalAdjustment', {
                    rules: [{ required: true, message: '请输入Total Adjustment' }],
                  })(
                    <Input placeholder="请输入Total Adjustment" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.totalAmount} {...formItemLayout}>
                  {getFieldDecorator('totalAmount', {
                    rules: [{ required: true, message: '请输入Total Amount' }],
                  })(
                    <Input placeholder="请输入Total Amount" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.lastUpdateTime} {...formItemLayout}>
                  {getFieldDecorator('lastUpdateTime', {
                    rules: [{ required: true, message: '请输入Last Update Time' }],
                  })(
                    <Input placeholder="请输入Last Update Time" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.user} {...formItemLayout}>
                  {getFieldDecorator('userId', {
                  	initialValue: tryinit('user'),
                    rules: [{ required: true, message: '请输入User' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('user')}
                    targetType={"user"} 
                    requestFunction={UserOrderService.requestCandidateUser}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.platform} {...formItemLayout}>
                  {getFieldDecorator('platformId', {
                  	initialValue: tryinit('platform'),
                    rules: [{ required: true, message: '请输入Platform' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('platform')}
                    targetType={"platform"} 
                    requestFunction={UserOrderService.requestCandidatePlatform}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<LineItemModalTable data={data.lineItemList} owner={owner} />
	<OrderPromotionModalTable data={data.orderPromotionList} owner={owner} />
	<ManualAdjustmentModalTable data={data.manualAdjustmentList} owner={owner} />
	<ShippingGroupModalTable data={data.shippingGroupList} owner={owner} />
	<PaymentGroupModalTable data={data.paymentGroupList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(UserOrderAssociateForm))




