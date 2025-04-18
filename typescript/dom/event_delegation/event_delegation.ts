// 给了一个html布局，form container里面有很多<textfield>，每个textfield下面都有一个问题标题，以及一些可点击的radio button. 要求实现点击任何一个radio button，都会弹出alert提示（文本任意）const parent = document.getElementById('parent');

// 在父元素上添加事件监听器

const parentElement = document.getElementById('parent');

parentElement.addEventListener('click', function(event) {
    // 检查事件目标是否是需要的子元素
    if (event.target instanceof HTMLElement && event.target.classList.contains('child')) {
        console.log(`Clicked on: ${event.target.innerText}`);
    }
});

// 动态添加一个按钮
const newButton = document.createElement('button');
newButton.className = 'child';
newButton.innerText = 'Button 3';
parentElement.appendChild(newButton);
