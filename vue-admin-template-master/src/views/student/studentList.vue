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
                    <el-select v-model="studentSearch.cid" placeholder="班级">
                        <el-option label="所有班级" value="-1"></el-option>
                        <el-option :label="c.className" :value="c.classId" v-for="c in classes" :key="c.classId" />
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="search()">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <span @click="addStudent()"><add-button /></span>
                </el-form-item>
                <el-form-item>
                    <span @click="deleteAllStudent()"><delete-button /></span>
                </el-form-item>
            </el-form>
            <el-table :data="studentList" style="width: 100%" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55">
                </el-table-column>

                <el-table-column label="序号" type="index" align="center" width="60"> <!-- 可以设置宽度来适应行号的显示 -->
                </el-table-column>

                <el-table-column label="学号" align="center">
                    <template slot-scope="scope">
                        <span>{{ scope.row.studentId }}</span>
                    </template>
                </el-table-column>

                <el-table-column label="姓名" align="center">
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
        <el-dialog :title="title" :visible.sync="dialogFormVisible" width="30%" :close-on-click-modal="false"
            :show-close="false">
            <el-form :model="editStudent">
                <el-form-item label="学生姓名" :label-width="formLabelWidth">
                    <el-input v-model="editStudent.studentName"></el-input>
                </el-form-item>
                <el-form-item label="年龄" :label-width="formLabelWidth">
                    <el-input v-model="editStudent.studentAge"></el-input>
                </el-form-item>
                <el-form-item label="性别" :label-width="formLabelWidth">
                    <el-select v-model="editStudent.sex" placeholder="请选择性别">
                        <el-option label="男" value="W"></el-option>
                        <el-option label="女" value="F"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="班级" :label-width="formLabelWidth">
                    <el-select v-model="editStudent.cname" placeholder="请选择班级">
                        <el-option :label="c.className" :value="c.className" v-for="c in classes" :key="c.classId" />
                    </el-select>
                </el-form-item>
                <el-form-item label="住址" :label-width="formLabelWidth">
                    <el-input v-model="editStudent.addr"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="quxiao()">取 消</el-button>
                <el-button type="primary" @click="save()">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import studentApi from "../../api/student.js"
import classesApi from "../../api/classes.js"
import classes from "../../api/classes.js"
import DeleteButton from "../../components/buttons/b1.vue"
import AddButton from "../../components/buttons/b2.vue"
export default {
    // 证明组件
    components: {
        DeleteButton,
        AddButton
    },
    data() {
        return {
            studentList: [],
            studentSearch: {},
            classes: [],
            page: 1,
            pageSize: 5,
            total: 100,
            dialogFormVisible: false,
            title: '',
            editStudent: {},
            formLabelWidth: '80px',
            multipleSelection: [],  // 代表勾选的要删除的多个学生数组
            sids: [],// 要删除的学生编号（可以同时放一个若多个，即可以删除一个或多个学生）
        }
    },
    created() {
        this.search()
        // this.findAllStudentM()
        this.findAllClasses()
    },
    methods: {
        // 批量删除
        handleSelectionChange(val) {
            this.multipleSelection = val
            this.sids = []
            for (let i = 0; i < val.length; i++) {
                const student = val[i]
                this.sids.push(student.studentId)
            }
        },
        deleteAllStudent() {
            if (this.multipleSelection && this.multipleSelection.length === 0) {
                this.openErr('您没有选择学生，请先选择')
                return
            }
            studentApi.deleteAllStudent(this.sids).then((data) => {
                if (data.code === 0) {
                    this.openSuc("删除成功！")
                } else {
                    this.openIfno("删除失败！")
                }
                this.page = 1
                this.search()
            })

        },
        addStudent() {
            this.title = "添加学生"
            this.editStudent = {}
            this.dialogFormVisible = true
        },
        quxiao() {
            this.dialogFormVisible = false
            this.editStudent = {}
            this.title = ''
            this.openIfno("你取消操作")
        },
        save() {
            for (let i = 0; i < this.classes.length; i++) {
                if (this.editStudent.cname == this.classes[i].className) {
                    this.editStudent.cid = this.classes[i].classId
                }
            }
            console.log("save", this.editStudent)
            var msg = ''
            // 检查studentId是否为null或undefined，如果是，则认为是添加
            if (this.editStudent.studentId === null || this.editStudent.studentId === undefined) {
                console.log("添加")
                // 执行添加操作的代码
                studentApi.addStudent(this.editStudent).then((data) => {
                    if (data.code === 0) {
                        msg = data.message
                        this.openSuc(msg)
                    }
                })
            } else {
                // 如果studentId不是null或undefined，认为是修改
                console.log("修改")
                // 执行修改操作的代码
                studentApi.updateStudent(this.editStudent).then((data) => {
                    if (data.code === 0) {
                        msg = data.message
                        this.openSuc(msg)
                    }
                })
            }
            this.dialogFormVisible = false
            this.search()
        },
        handleEdit(id) {
            this.title = "编辑信息"
            this.dialogFormVisible = true
            studentApi.findStudentById(id).then(({ data }) => {
                this.editStudent = data.student
            })
        },
        handleDelete(id) {
            this.$confirm('此操作将永久删除该学生, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                studentApi.deleteStudentById(id).then((data) => {
                    if (data.code === 0) {
                        this.openSuc('删除成功!')
                    } else {
                        this.openErr('删除失败!')
                    }
                    this.page = 1
                    this.search()
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                })
            })
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
            })
            this.studentSearch = {}
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
        openIfno(msg) {
            this.$message({
                message: msg,
                type: 'info'
            })
        },
        openErr(msg) {
            this.$message({
                message: msg,
                type: 'error'
            })
        },
    },

}
</script>
<style lang='css' scoped></style>