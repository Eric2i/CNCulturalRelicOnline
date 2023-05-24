import request from '@/utils/request'

// 查询图片信息列表
export function listPic(query) {
  return request({
    url: '/system/pic/list',
    method: 'get',
    params: query
  })
}

// 查询图片信息详细
export function getPic(id) {
  return request({
    url: '/system/pic/' + id,
    method: 'get'
  })
}

// 新增图片信息
export function addPic(data) {
  return request({
    url: '/system/pic',
    method: 'post',
    data: data
  })
}

// 修改图片信息
export function updatePic(data) {
  return request({
    url: '/system/pic',
    method: 'put',
    data: data
  })
}

// 删除图片信息
export function delPic(id) {
  return request({
    url: '/system/pic/' + id,
    method: 'delete'
  })
}
