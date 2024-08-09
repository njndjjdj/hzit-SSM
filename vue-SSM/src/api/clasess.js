import request from '@/util/request'

export default {
    // 1. 查询所有班级信息
    findAllClasess() {
        return request({
            url: '/class/findAllClass',
            method: 'get',
        })
    }
}