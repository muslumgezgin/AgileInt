import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootREducer from "./reducers";

const initialState = {};
const middleware = [thunk];

let store;

if (window.navigator.userAgent.includes("Chrome")) {
  store = createStore(
    rootREducer,
    initialState,
    compose(
      applyMiddleware(...middleware),
      window.__REDUX_DEVTOOLS_EXTENSION__ &&
        window.__REDUX_DEVTOOLS_EXTENSION__()
    )
  );
} else {
  store = createStore(
    rootREducer,
    initialState,
    compose(applyMiddleware(...middleware))
  );
}
export default store;
