function throttle(fn, delay) {
    let lastTime = 0;
    
    return function(...args) {
      const now = Date.now();
      
      if (now - lastTime >= delay) {
        fn.apply(this, args);
        lastTime = now;
      }
    }
  }
  
  // 使用示例:
  window.addEventListener('scroll', throttle(() => {
    console.log('scroll事件被触发');
  }, 1000));
  