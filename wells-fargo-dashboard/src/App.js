import './App.css';
import {useRef} from "react";
function App() {
  const inputRef = useRef(null);
  const emailRef = useRef(null);
  const submit =() =>{
    
    const emailInput = emailRef.current;
    const passwordInput = inputRef.current;

  if (!emailInput.checkValidity() || !passwordInput.checkValidity()) { // ✅ catches invalid email
    alert(emailInput.validationMessage +" " + passwordInput.validationMessage); // shows built-in message
    return;
  }
  
 
   
    

   
    
}
  return (
    
    <>
    <header>
      <div id="title">
        {/* <img src='wells-fargo-dashboard/public/wells-Fargo.png' alt='logo'> </img> */}
        <img src='/wells-Fargo.png' alt='wellsFargo'></img>
        <div id="dash-title">Dash Board Login</div>
      </div>

    </header>
    <main id='form-body'>
      
      <label>email</label>
      <input id = "email" required ref={emailRef} type ='email' ></input>
      <label>Password</label>
      <input required type='text' ref={inputRef}></input>
      <button id = "submit" onClick={submit}>Login</button>


    </main>

   </>
  );
}

export default App;
