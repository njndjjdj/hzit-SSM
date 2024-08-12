import request from '@/utils/request'


export default {
    findAllClasses() {
        return request({
            url: '/classes/findAllClasses',
            method: 'get',
        })
    }
}