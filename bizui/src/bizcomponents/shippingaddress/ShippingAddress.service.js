import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}shippingAddressManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}shippingAddressManager/loadShippingAddress/${targetObjectId}/${parametersExpr}/`,
  })
}






const ShippingAddressService = { view,
  load }
export default ShippingAddressService

