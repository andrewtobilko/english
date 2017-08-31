import React, {Component} from "react";

import SearchBar from './search-bar';
import SearchResults from '../containers/search-results.container';

class App extends Component {

    render() {
        return (
            <div>
                <SearchBar/>
                <SearchResults/>
            </div>
        );
    }

}

export default App;