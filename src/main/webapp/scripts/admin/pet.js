"use strict";var l=(t,o,n)=>new Promise((g,i)=>{var u=e=>{try{d(n.next(e))}catch(a){i(a)}},E=e=>{try{d(n.throw(e))}catch(a){i(a)}},d=e=>e.done?g(e.value):Promise.resolve(e.value).then(u,E);d((n=n.apply(t,o)).next())});function f(t){return l(this,null,function*(){t.preventDefault();let o=document.getElementById("add-pet-dialog");if(o instanceof HTMLDialogElement){let{status:n}=yield fetch(this.action,{method:"post",body:new URLSearchParams(new FormData(this))});o.close()}})}function r(){let t=document.getElementById("add-pet-dialog");t instanceof HTMLDialogElement&&t.showModal()}function h(){let t=document.getElementById("add-pet-dialog");t instanceof HTMLDialogElement&&t.close()}var s;(s=document.getElementById("add-pet-form"))==null||s.addEventListener("submit",f);var m;(m=document.getElementById("add-pet-button"))==null||m.addEventListener("pointerdown",r);var c;(c=document.getElementById("add-pet-back"))==null||c.addEventListener("pointerdown",h);
