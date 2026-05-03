import { printLog } from './utils.js';


// click: 点击事件
document.querySelector('#b2').addEventListener('click', function () {
    console.log('点击事件');
})

// mouseenter: 鼠标进入事件
document.querySelector('#last').addEventListener('mouseenter', function () {
    console.log('鼠标进入事件');
})

// mouseleave: 鼠标离开事件
document.querySelector('#last').addEventListener('mouseleave', function () {
    console.log('鼠标离开事件');
})

// keydown: 按键按下事件
document.querySelector('#username').addEventListener('keydown', function () {
    console.log('按键按下事件');
})

// keyup: 按键抬起事件
document.querySelector('#username').addEventListener('keyup', function () {
    console.log('按键抬起事件');
})

// blur: 失去焦点事件
document.querySelector('#age').addEventListener('blur', function () {
    console.log('失去焦点事件');
})

// focus: 获取焦点事件
document.querySelector('#age').addEventListener('focus', function () {
    console.log('获取焦点事件');
})

// input: 输入事件
document.querySelector('#age').addEventListener('input', function () {
    console.log('输入事件');
})

// submit: 提交事件
document.querySelector('form').addEventListener('submit', function () {
    alert('提交事件');
})
