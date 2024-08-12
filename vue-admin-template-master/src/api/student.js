import request from '@/utils/request'


export default {
    findAllStudent() {
        return request({
            url: '/student/findAllStudent',
            method: 'get',
        })
    },
    search(page, pageSize, data) {
        return request({
            url: `/student/search/${page}/${pageSize}`,
            method: 'post',
            data
        })
    },
}