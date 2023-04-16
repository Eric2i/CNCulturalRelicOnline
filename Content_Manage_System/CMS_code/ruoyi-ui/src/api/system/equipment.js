import request from '@/utils/request'

// 查询器材信息列表
export function listEquipment(query) {
  return request({
    url: '/system/equipment/list',
    method: 'get',
    params: query
  })
}

// 查询器材信息详细
export function getEquipment(id) {
  return request({
    url: '/system/equipment/' + id,
    method: 'get'
  })
}

// 新增器材信息
export function addEquipment(data) {
  return request({
    url: '/system/equipment',
    method: 'post',
    data: data
  })
}

// 修改器材信息
export function updateEquipment(data) {
  return request({
    url: '/system/equipment',
    method: 'put',
    data: data
  })
}

// 删除器材信息
export function delEquipment(id) {
  return request({
    url: '/system/equipment/' + id,
    method: 'delete'
  })
}
