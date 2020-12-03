import './App.css';
import {Component} from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import SignUpForm from "../Components/Form/Authentication/SignUpForm";
import LoginForm from "../Components/Form/Authentication/LoginForm";
import {login, signUp} from "../Actions/Authentication";

class App extends Component{

  render() {
    return (
        <BrowserRouter>
          <div className={"App card-body w-25 row d-flex mx-auto"} >
            <Switch>
              <Route exact path="/signup" render={() => (<SignUpForm submit={signUp} />)}/>
              <Route exact path="/" render={() => (<LoginForm submit={login} />)}/>
            </Switch>
          </div>
        </BrowserRouter>
    )
  }
}

export default App;
