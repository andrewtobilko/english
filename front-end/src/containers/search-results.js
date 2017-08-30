import React, {Component} from 'react';
import SearchResult from "../components/search-result";
import {connect} from 'react-redux';

import {resultSelect} from '../actions/index'
import {bindActionCreators} from 'redux';

class SearchResults extends Component {

    renderResults() {
        return this.props.results.map(result =>
            <div onClick={this.props.selectedResult(result)}>
                <SearchResult
                    key={result.id}
                    value={result.value}
                />
            </div>
        );
    }

    render() {
        return (
            <div>{this.renderResults()}</div>
        );
    }

}

function mapStateToProps(state) {
    return {
        results: state.results
    }
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators({
        selectedResult: resultSelect
    }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(SearchResults)