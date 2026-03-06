import './App.css';

function App() {
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
      <input type='text' ></input>
      <label>Password</label>
      <input type='text'></input>
      <button id = "submit">Login</button>


    </main>

   </>
  );
}

export default App;
