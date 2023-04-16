import request from '@/utils/request'

// 查询预约记录列表
export function listAppointment(query) {
  return request({
    url: '/system/appointment/list',
    method: 'get',
    params: query
  })
}

// 查询预约记录详细
export function getAppointment(id) {
  return request({
    url: '/system/appointment/' + id,
    method: 'get'
  })
}

// 新增预约记录
export function addAppointment(data) {
  return request({
    url: '/system/appointment',
    method: 'post',
    data: data
  })
}

// 修改预约记录
export function updateAppointment(data) {
  return request({
    url: '/system/appointment',
    method: 'put',
    data: data
  })
}

// 删除预约记录
export function delAppointment(id) {
  return request({
    url: '/system/appointment/' + id,
    method: 'delete'
  })
}
