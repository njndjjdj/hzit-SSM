<!--  -->
<template>
    <div class='app-container'>
        <el-card shadow="always">
            <el-form :inline="true" :model="studentSearch" class="demo-form-inline">
                <el-form-item label="学号">
                    <el-input v-model="studentSearch.studentId" placeholder="学号"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="studentSearch.studentName" placeholder="姓名"></el-input>
                </el-form-item>
                <el-form-item label="班级">
                    <el-select v-model="studentSearch.classId" placeholder="班级">
                        <el-option label="所有班级" value="-1"></el-option>
                        <el-option :label="c.className" :value="c.classId" v-for="c in classes" :key="c.classId" />
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="search()">查询</el-button>
                </el-form-item>
            </el-form>
            <el-table :data="studentList" style="width: 100%">

                <el-table-column label="序号" type="index" align="center" width="60"> <!-- 可以设置宽度来适应行号的显示 -->
                </el-table-column>

                <el-table-column label="学号" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.studentId }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="姓名">
                    <template slot-scope="scope">
                        <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.studentName }}</p>
                            <p>住址: {{ scope.row.addr }}</p>
                            <div slot="reference" class="name-wrapper">
                                <el-tag size="medium">{{ scope.row.studentName }}</el-tag>
                            </div>
                        </el-popover>
                    </template>
                </el-table-column>

                <el-table-column label="年龄" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.studentAge }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="性别" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.sex }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="班级" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.cname }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="住址" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.addr }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.row.studentId)">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.row.studentId)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" align="right"
                :current-page="page" :page-sizes="[5, 10, 15, 20]" :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper" :total="total">
            </el-pagination>
        </el-card>
    </div>
</template>

<script>
import studentApi from "../../api/student.js"
import classesApi from "../../api/classes.js"
export default {
    data() {
        return {
            studentList: [],
            studentSearch: {},
            classes: [],
            page: 1,
            pageSize: 5,
            total: 100,
        }
    },
    created() {
        this.search()
        // this.findAllStudentM()
        this.findAllClasses()
    },
    methods: {
        handleEdit(id) {
            alert(id)
        },
        handleDelete(id) {
            alert(id)
        },
        findAllStudentM() {
            studentApi.findAllStudent().then(({ data }) => {
                this.studentList = data.studentList
            })
        },
        findAllClasses() {
            classesApi.findAllClasses().then(({ data }) => {
                this.classes = data.classList
            })
        },
        search() {
            studentApi.search(this.page, this.pageSize, this.studentSearch).then(({ data }) => {
                console.log(this.studentSearch)
                this.studentList = data.studentList.result
                this.total = data.studentList.total
                this.openSuc("查询成功")
            })
        },
        handleSizeChange(pageSize) {
            this.pageSize = pageSize
            this.page = 1
            this.search()
        },
        handleCurrentChange(page) {
            this.page = page
            this.search()
        },
        openSuc(msg) {
            this.$message({
                message: msg,
                type: 'success'
            })
        },
    },

}
</script>
<style lang='css' scoped></style>