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
    findStudentById(id) {
        return request({
            url: `/student/findStudentById/${id}`,
            method: 'get'
        })
    },
    addStudent(data) {
        return request({
            url: `/student/insertOrUpdateStudent`,
            method: 'post',
            data
        })
    },
    updateStudent(data) {
        return request({
            url: `/student/insertOrUpdateStudent`,
            method: 'post',
            data
        })
    },
    deleteStudentById(id) {
        return request({
            url: `/student/deleteStudentById/${id}`,
            method: 'get'
        })
    },
    deleteAllStudent(array) { 
        return request({
            url: `/student/deleteAllStudent/${array}`,
            method: 'get'
        })
    }
}