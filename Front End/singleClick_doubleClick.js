//写一个lib支持单击和双击分别执行不同的function
const button = document.getElementById('button')
let timer
button.addEventListener('click', event => {
  if (event.detail === 1) {
    timer = setTimeout(() => {
      console.log('click')
    }, 200)
  }
})
button.addEventListener('dblclick', event => {
  clearTimeout(timer)
  console.log('dblclick')
})

//<button id="button">Click me</button>
