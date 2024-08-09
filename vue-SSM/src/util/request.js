import axios from 'axios'

let service = axios.create({
    baseURL: '/api',
    timeout: 10000
})

export default service