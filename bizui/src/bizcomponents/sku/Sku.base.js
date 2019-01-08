
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Sku", menuFor: "sku",
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
  { title: 'Display Name', debugtype: 'string', dataIndex: 'displayName', width: '17',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Size', debugtype: 'string', dataIndex: 'size', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Product', dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Active', dataIndex: 'active', render: (text, record) =>renderBooleanCell(text, record) },
  { title: 'Base Price', dataIndex: 'basePrice', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: 'Last Update Time', debugtype: 'string', dataIndex: 'lastUpdateTime', width: '20',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: 'Id',
  displayName: 'Display Name',
  size: 'Size',
  product: 'Product',
  active: 'Active',
  basePrice: 'Base Price',
  lastUpdateTime: 'Last Update Time',

}


const SkuBase={menuData,displayColumns,fieldLabels,displayColumns}
export default SkuBase



