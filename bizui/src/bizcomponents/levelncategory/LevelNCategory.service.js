import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelNCategoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelNCategoryManager/loadLevelNCategory/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelNCategoryManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}levelNCategoryManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addProduct/levelNCategoryId/displayName/brandId/origin/catalogId/remark/lastUpdateTime/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateProductProperties/levelNCategoryId/id/displayName/origin/remark/lastUpdateTime/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeProductList/levelNCategoryId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const LevelNCategoryService = { view,
  load,
  addProduct,
  updateProduct,
  removeProductList,
  requestCandidateParentCategory,
  transferToAnotherParentCategory }
export default LevelNCategoryService

