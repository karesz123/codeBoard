import './App.css';
import {Component} from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import SignUpForm from "../Components/Form/Authentication/SignUpForm";
import LoginForm from "../Components/Form/Authentication/LoginForm";
import {login, signUp} from "../Service/Authentication";

class App extends Component{

  render() {
    return (
        <BrowserRouter>
          <div className={"App card-body w-25 row d-flex mx-auto"} >
            <Switch>
                <Route exact path="/homepage" render={(routeProps) => (window.location.href="homepage.html")}/>
                <Route exact path="/signup" render={(routeProps) => (<SignUpForm submit={signUp} {...routeProps}/>)}/>
                <Route exact path= "/" render={(routeProps) => (<LoginForm submit={login}  {...routeProps}/>)}/>
            </Switch>
          </div>
        </BrowserRouter>
    )
  }
}

export default App;
