
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Shipping Group", menuFor: "shippingGroup",
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
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '16',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Line1', debugtype: 'string', dataIndex: 'line1', width: '29',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Line2', debugtype: 'string', dataIndex: 'line2', width: '16',render: (text, record)=>renderTextCell(text,record) },
  { title: 'City', debugtype: 'string', dataIndex: 'city', width: '19',render: (text, record)=>renderTextCell(text,record) },
  { title: 'State', debugtype: 'string', dataIndex: 'state', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Zip Code', debugtype: 'int', dataIndex: 'zipCode', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Country', debugtype: 'string_country_code', dataIndex: 'country', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: 'User Order', dataIndex: 'userOrder', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  line1: 'Line1',
  line2: 'Line2',
  city: 'City',
  state: 'State',
  zipCode: 'Zip Code',
  country: 'Country',
  userOrder: 'User Order',

}


const ShippingGroupBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ShippingGroupBase



