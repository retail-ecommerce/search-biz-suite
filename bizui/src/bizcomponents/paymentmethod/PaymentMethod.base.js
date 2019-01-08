
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Payment Method", menuFor: "paymentMethod",
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
  { title: 'Name', debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Number', debugtype: 'string', dataIndex: 'number', width: '17',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Line1', debugtype: 'string', dataIndex: 'line1', width: '26',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Line2', debugtype: 'string', dataIndex: 'line2', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: 'City', debugtype: 'string', dataIndex: 'city', width: '16',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Expire On', dataIndex: 'expireOn', render: (text, record) =>renderDateCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  number: 'Number',
  line1: 'Line1',
  line2: 'Line2',
  city: 'City',
  expireOn: 'Expire On',

}


const PaymentMethodBase={menuData,displayColumns,fieldLabels,displayColumns}
export default PaymentMethodBase



