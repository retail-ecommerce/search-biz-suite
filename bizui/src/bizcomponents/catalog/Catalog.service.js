import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}catalogManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}catalogManager/loadCatalog/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateSite = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}catalogManager/requestCandidateSite/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSite = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}catalogManager/transferToAnotherSite/id/anotherSiteId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addLevelOneCategory/catalogId/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateLevelOneCategoryProperties/catalogId/id/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelOneCategoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeLevelOneCategoryList/catalogId/levelOneCategoryIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addProduct/catalogId/name/parentCategoryId/brandId/origin/remark/lastUpdateTime/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateProductProperties/catalogId/id/name/origin/remark/lastUpdateTime/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeProductList/catalogId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const CatalogService = { view,
  load,
  addLevelOneCategory,
  addProduct,
  updateLevelOneCategory,
  updateProduct,
  removeLevelOneCategoryList,
  removeProductList,
  requestCandidateSite,
  transferToAnotherSite }
export default CatalogService

