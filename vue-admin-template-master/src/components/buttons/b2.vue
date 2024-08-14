<template>
    <button> 添加学生</button>
</template>

<style scoped>
button {
    position: relative;
    display: inline-block;
    padding: 8px 20px;
    text-align: center;
    font-size: 16px;
    letter-spacing: 1px;
    text-decoration: none;
    color: #725AC1;
    background: transparent;
    cursor: pointer;
    transition: ease-out 0.5s;
    border: 2px solid #725AC1;
    border-radius: 10px;
    box-shadow: inset 0 0 0 0 #725AC1;
}

button:hover {
    color: white;
    box-shadow: inset 0 -100px 0 0 #725AC1;
}

button:active {
    transform: scale(0.9);
}
</style>

<script>
export default {
    name: 'AddButton',
}
</script>