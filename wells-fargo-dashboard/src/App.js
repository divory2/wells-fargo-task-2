import './App.css';
import {useRef, useState} from "react";
import axios from "axios";
function App() {
  const inputRef = useRef(null);
  const emailRef = useRef(null);
  const [loading,setLoading] = useState(false);
  const submit =async () =>{
    
    const emailInput = emailRef.current;
    const passwordInput = inputRef.current;

  if (!emailInput.checkValidity() || !passwordInput.checkValidity()) { // ✅ catches invalid email
    alert(emailInput.validationMessage +" " + passwordInput.validationMessage); // shows built-in message
    return;
  } 
  setLoading(true)
    try{
      const response = await axios.post("/api/login", 
        { emailInput, 
          passwordInput 

        });
      console.log("Login successful:", response.data);
    }
    catch(error)
    {
      console.error("Login failed:", error);
      alert("Login failed. Please try again.");

    }
    finally{
      setLoading(false);
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
      {loading ? (
      <div className='loading-container'>
        <div className='spinner'></div>
      </div>
    ) :(
      <><label>email</label><input id="email" required ref={emailRef} type='email'></input><label>Password</label><input required type='text' ref={inputRef}></input><button id="submit" onClick={submit}>Login</button></>
    )}
  
    </main>

   </>
  );
}

export default App;
