import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}productManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}productManager/loadProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBrand = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateBrand/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBrand = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherBrand/id/anotherBrandId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCatalog = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateCatalog/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCatalog = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherCatalog/id/anotherCatalogId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProductRecommendation = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addProductRecommendation/productId/name/brandId/origin/remark/lastUpdateTime/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProductRecommendation = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateProductRecommendationProperties/productId/id/name/origin/remark/lastUpdateTime/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductRecommendationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeProductRecommendationList/productId/productRecommendationIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSku = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addSku/productId/name/size/active/basePrice/lastUpdateTime/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSku = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateSkuProperties/productId/id/name/size/active/basePrice/lastUpdateTime/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSkuList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeSkuList/productId/skuIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProductService = { view,
  load,
  addProductRecommendation,
  addSku,
  updateProductRecommendation,
  updateSku,
  removeProductRecommendationList,
  removeSkuList,
  requestCandidateParentCategory,
  requestCandidateBrand,
  requestCandidateCatalog,
  transferToAnotherParentCategory,
  transferToAnotherBrand,
  transferToAnotherCatalog }
export default ProductService

