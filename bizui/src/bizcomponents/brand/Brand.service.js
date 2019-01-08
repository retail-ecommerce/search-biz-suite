import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}brandManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}brandManager/loadBrand/${targetObjectId}/${parametersExpr}/`,
  })
}







const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addProduct/brandId/displayName/parentCategoryId/origin/catalogId/remark/lastUpdateTime/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateProductProperties/brandId/id/displayName/origin/remark/lastUpdateTime/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeProductList/brandId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProductRecommendation = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addProductRecommendation/brandId/displayName/origin/productId/remark/lastUpdateTime/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProductRecommendation = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateProductRecommendationProperties/brandId/id/displayName/origin/remark/lastUpdateTime/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductRecommendationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeProductRecommendationList/brandId/productRecommendationIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const BrandService = { view,
  load,
  addProduct,
  addProductRecommendation,
  updateProduct,
  updateProductRecommendation,
  removeProductList,
  removeProductRecommendationList }
export default BrandService

