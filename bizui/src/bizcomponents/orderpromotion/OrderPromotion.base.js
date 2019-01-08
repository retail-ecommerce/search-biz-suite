
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Order Promotion", menuFor: "orderPromotion",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '19',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Amount', debugtype: 'int', dataIndex: 'amount', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Thread Hold', debugtype: 'int', dataIndex: 'threadHold', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Type', debugtype: 'string', dataIndex: 'type', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: 'User Order', dataIndex: 'userOrder', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  amount: 'Amount',
  threadHold: 'Thread Hold',
  type: 'Type',
  userOrder: 'User Order',

}


const OrderPromotionBase={menuData,displayColumns,fieldLabels,displayColumns}
export default OrderPromotionBase



