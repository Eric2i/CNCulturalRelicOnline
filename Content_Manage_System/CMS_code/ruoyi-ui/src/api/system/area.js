import request from '@/utils/request'

// 查询场地信息列表
export function listArea(query) {
  return request({
    url: '/system/area/list',
    method: 'get',
    params: query
  })
}

// 查询场地信息详细
export function getArea(id) {
  return request({
    url: '/system/area/' + id,
    method: 'get'
  })
}

// 新增场地信息
export function addArea(data) {
  return request({
    url: '/system/area',
    method: 'post',
    data: data
  })
}

// 修改场地信息
export function updateArea(data) {
  return request({
    url: '/system/area',
    method: 'put',
    data: data
  })
}

// 删除场地信息
export function delArea(id) {
  return request({
    url: '/system/area/' + id,
    method: 'delete'
  })
}
