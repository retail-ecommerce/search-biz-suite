import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}paymentMethodManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}paymentMethodManager/loadPaymentMethod/${targetObjectId}/${parametersExpr}/`,
  })
}






const PaymentMethodService = { view,
  load }
export default PaymentMethodService

