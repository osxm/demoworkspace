import Mock from 'mockjs'

Mock.setup({
    timeout: '300-600'
})

Mock.mock('/api/test', 'get', {
    name: 'Oscar',
})

export default Mock