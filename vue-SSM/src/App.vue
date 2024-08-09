<template>
  <div id="app">
    <el-col :span="24">
      <el-card shadow="hover">
        <el-form :inline="true" :model="searchStudent" class="demo-form-inline">
          <el-form-item label="学号">
            <el-input v-model="searchStudent.stuno" placeholder="学号"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="searchStudent.stuname" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item label="班级">
            <el-select v-model="searchStudent.classno" placeholder="班级">
              <el-option label="全选" value="0"></el-option>
              <el-option v-for="c in clasess" :label="c.classname" :value="c.classno" :key="c.classno"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="search()">查询</el-button>
          </el-form-item>

          <el-form-item>
            <div @click="addStudent()"><add-button /></div>
          </el-form-item>

          <el-form-item>
            <div @click="deleteStudents()"><delete-button /></div>
          </el-form-item>
        </el-form>

        <el-table :data="studentData" style="width: 100%" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55">
          </el-table-column>

          <el-table-column type="index" label="行号" align="center" :index="(page - 1) * pageSize + 1">
          </el-table-column>

          <el-table-column label="学号" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.stuno }}</span>
            </template>
          </el-table-column>

          <el-table-column label="姓名" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.stuname }}</span>
            </template>
          </el-table-column>

          <el-table-column label="班级" align="center">
            <template slot-scope="scope">
              <span>{{ getClassesName(scope.row.classno) }}</span>
            </template>
          </el-table-column>

          <el-table-column label="性别" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.sex }}</span>
            </template>
          </el-table-column>

          <el-table-column label="年龄" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.age }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="handleDelete(scope.row.stuno)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page"
          :page-sizes="[5, 10, 15, 20, total]" :page-size="pageSize" layout="->,total, sizes, prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </el-card>
    </el-col>
    <el-dialog :title="title" :visible.sync="dialogFormVisible" :close-on-click-modal="false" width="20%"
      :show-close="false" :close-on-press-escape="false">
      <el-form :model="insertOrUpdateStudent">
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="insertOrUpdateStudent.stuno" autocomplete="off" :disabled="disabled"></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="insertOrUpdateStudent.stuname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="班级" :label-width="formLabelWidth">
          <el-select v-model="insertOrUpdateStudent.classno" placeholder="请选择活动区域">
            <el-option v-for="c in clasess" :label="c.classname" :value="c.classno" :key="c.classno"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-select v-model="insertOrUpdateStudent.sex" placeholder="请选择性别">
            <el-option label="男" value="M"></el-option>
            <el-option label="女" value="F"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input v-model="insertOrUpdateStudent.age" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="noDailog()">取 消</el-button>
        <el-button type="primary" @click="yesDialog()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import studentApi from '@/api/student.js'
import clasessApi from '@/api/clasess.js'
import DeleteButton from './buttons/b1.vue'
import AddButton from './buttons/b2.vue'
export default {
  // 证明组件
  components: {
    DeleteButton,
    AddButton
  },
  data() {
    return {
      studentData: [],
      page: 1,
      pageSize: 5,
      total: 100,
      searchStudent: {},
      clasess: [],
      className: '',
      student: {},
      dialogFormVisible: false,
      insertOrUpdateStudent: {},
      title: '',
      formLabelWidth: '40px',
      classNo: '',
      disabled: true,//默认学号不能改
      multipleSelection: [],  // 代表勾选的要删除的多个学生数组
      sids: [],// 要删除的学生编号（可以同时放一个若多个，即可以删除一个或多个学生）

    }
  },
  methods: {
    // 1. 用户点击勾选要删除的学生后，得到的multipleSelection数组
    handleSelectionChange(val) {
      this.multipleSelection = val
      for (let i = 0; i < val.length; i++) {
        const student = val[i]
        // 如果学生已经被选中，则添加其ID到sids数组中
        if (!this.sids.includes(student.stuno)) {
          this.sids.push(student.stuno)
        }
      }
      for (let i = this.multipleSelection.length - 1; i >= 0; i--) {
        const index = this.sids.indexOf(this.multipleSelection[i].stuno)
        // 如果学生被取消选中，则从sids数组中移除其ID
        if (index !== -1) {
          this.sids.splice(index, 1)
        }
      }
      console.log("复选矿选中的id", this.multipleSelection)

    },
    deleteStudents() {
      if (this.multipleSelection && this.multipleSelection.length === 0) {
        this.errorOpen('您没有选择学生，请先选择')
        return
      }
      this.multipleSelection.map(m => {
        this.sids.push(m.stuno)
      })
      console.log("学生id集合", this.sids)
      studentApi.deleteAllStudentById(this.sids).then(({ data }) => {
        console.log(data)
        if (data.data.msg == '删除成功') {
          this.successOpen(data.data.msg)
        }
        this.search()
      })
    },
    getClassesName(cid) {
      for (let index = 0; index < this.clasess.length; index++) {
        if (cid == this.clasess[index].classno) {
          this.className = this.clasess[index].classname
          this.classNo = this.clasess[index].classno
          return this.clasess[index].classname
        }
      }
    },
    addStudent() {
      this.insertOrUpdateStudent = {}
      this.dialogFormVisible = true
      this.title = '添加学生'
      this.disabled = false
      console.log("添加学生的时候的模型", this.insertOrUpdateStudent)
    },
    // 修改
    handleEdit(student) {
      this.findAllClasess()
      this.insertOrUpdateStudent = student
      this.getClassesName(this.insertOrUpdateStudent.classno)
      this.insertOrUpdateStudent.classno = this.className
      this.dialogFormVisible = true
      this.title = '修改学生信息'
      this.insertOrUpdateStudent.classno = this.classNo
      this.insertOrUpdateStudent.sex == '女' ? this.insertOrUpdateStudent.sex = 'F' : this.insertOrUpdateStudent.sex = 'M'
      console.log("修改学生的时候的模型", this.insertOrUpdateStudent)
    },
    yesDialog() {
      this.insertOrUpdateStudentM(this.insertOrUpdateStudent)
      console.log(this.insertOrUpdateStudent)
      this.dialogFormVisible = false
    },
    noDailog() {
      this.dialogFormVisible = false
      console.log(this.insertOrUpdateStudent)
      this.search()
    },
    insertOrUpdateStudentM(data) {
      this.dialogFormVisible = false
      studentApi.insertOrUpdateStudent(data).then(({ data }) => {
        console.log(111)
        if (data.data.msg == '修改成功' || data.data.msg == '添加成功') {
          console.log(222)
          this.successOpen(data.data.msg)
        } else {
          this.errorOpen(data.data.msg)
        }
        this.search()
      })
    },
    // 删除
    handleDelete(id) {
      console.log(id)
      this.openAlter(id)
    },
    errorOpen(msg) {
      this.$notify.error({
        title: '错误',
        message: msg
      })
    },
    successOpen(msg) {
      this.$notify({
        title: '成功',
        message: msg,
        type: 'success'
      })
    },
    openAlter(id) {
      this.$confirm('此操作将永久删除该学生, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        studentApi.deleteStudentById(id).then(({ data }) => {
          console.log("删除操作", data)
          if (data.data.msg === '删除成功') {
            this.successOpen(data.data.msg)
            this.search()
          } else {
            this.errorOpen(data.data.msg)
          }
        })
      }).catch(() => {
        this.openCl('取消删除')
      })
    },
    openCl(msg) {
      this.$message({
        showClose: true,
        message: msg
      })
    },
    selectStudentById(id) {
      this.student = null
    },
    findAll() {
      studentApi.findAllStudent().then(({ data }) => {
        this.studentData = data.data.students
        console.log(data)
        console.log("请求成功")
      }).catch((err) => {
        console.log("请求失败")
        console.log(err)
      })
    },
    // 每页显示数被改变时触发
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.page = 1
      // alert(pageSize)
      // this.findStudentByPage(this.page, this.pageSize)
      this.search()
    },
    // 页码被改变时触发
    handleCurrentChange(page) {
      this.page = page
      // alert(page)
      // this.findStudentByPage(this.page, this.pageSize)
      this.search()
    },
    findStudentByPage() {
      studentApi.findStudentByPage(this.page, this.pageSize).then(({ data }) => {
        console.log("学生信息", data)
        this.studentData = data.data.findStudentByPage.result
        this.total = data.data.findStudentByPage.total
        console.log("请求成功")
      }).catch((err) => {
        console.log("请求失败")
        console.log(err)
      })
    },
    search() {
      studentApi.search(this.page, this.pageSize, this.searchStudent).then(({ data }) => {
        console.log("分页查询待条件结果", data, this.page, this.pageSize, this.searchStudent)
        this.studentData = data.data.students.result
        this.total = data.data.students.total
        this.searchStudent = {}
      })
    },
    findAllClasess() {
      clasessApi.findAllClasess().then(({ data }) => {
        console.log("班级信息", data)
        this.clasess = data.data.class
      })
    }
  },

  created() {
    // this.findAll()
    // 默认进行分页查询
    // this.findStudentByPage()
    this.search()
    this.findAllClasess()
  }
}
</script>
<style>
#div {
  width: 80%;
}

.el-card {
  width: 80%;
  margin: 0 auto;
}

.el-pagination {
  margin-top: 20px;
}

/* From Uiverse.io by adamgiebl */
</style>
