import React, {Component} from 'react';
import {connect} from 'react-redux';

import ResultDetails from './result-details.container'

class SearchResults extends Component {

    renderResults() {
        const results = this.props.results;

        if (!results) {
            return <div>There is no results. Type something into the search bar.</div>
        }

        console.log(results);

        return results.map(result => {
                console.log('result = ', result);
                return (
                    <ResultDetails key={result.id}/>
                );
            }
        );
    }

    render() {
        return (
            <div>
                <h1>Search results:</h1>
                <div>{this.renderResults()}</div>
            </div>
        );
    }

}

function mapStateToProps(state) {
    return {
        results: state.results
    }
}

export default connect(mapStateToProps)(SearchResults)