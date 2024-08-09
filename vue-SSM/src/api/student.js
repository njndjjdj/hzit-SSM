import request from '@/util/request'

export default {
    // 1. 查询所有学生
    findAllStudent() {
        return request({
            url: '/student?cmd=findAllStudent',
            method: 'get',
        })
    },
    // 分页查询
    findStudentByPage(page, pageSize) {
        return request({
            url: `/student?cmd=findStudentByPage&page=${page}&pageSize=${pageSize}`,
            method: 'get',
        })
    },
    // 分页查询带参数
    search(page, pageSize, data) {
        return request({
            url: `/student/findAllStudent/${page}/${pageSize}`,
            method: 'post',
            data,
        })
    },
    // 删除学生
    deleteStudentById(id) {
        return request({
            url: `/student?cmd=deleteStudentById&id=${id}`,
            method: 'get',
        })
    },
    // 根据id查询学生
    selectStudentById(id) {
        return request({
            url: `/student?cmd=selectStudentById&id=${id}`,
            method: 'get',
        })
    },
    // 新增或修改学生
    insertOrUpdateStudent(data) {
        return request({
            url: `/student?cmd=insertOrUpdateStudent`,
            method: 'post',
            data,
        })
    },
    // 批量删除学生
    // 新增或修改学生
    deleteAllStudentById(sids) {
        return request({
            url: `/student?cmd=deleteAllStudentById&sids=${sids}`,
            method: 'get'
        })
    },
}