import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';


export default function UpdateRecipe() {
    const { id } = useParams();

    const [recipeTitle, setRecipeTitle] = useState(null);
    const [recipeIngrd, setRecipeIngrd] = useState(null);
    const [recipeDesc, setRecipeDesc] = useState(null);
    let navigate = useNavigate();

    //Calling the second api
    useEffect(() => {

        axios.get(
            `https://ddsbbackend.herokuapp.com/recipes/${id}`).then((response) => {
                console.log(response.data);
                setRecipeTitle(response.data.recipeTitle)
                setRecipeIngrd(response.data.recipeIngrd)
                setRecipeDesc(response.data.recipeDesc)

            })


            .catch(error => {
                console.log(error);
            })


    }, [id])

    const [errorMsg, setErrorMsg] = useState("");


    function handleSubmit() {
        setErrorMsg("");
        if (recipeTitle.trim() === "") {
            setErrorMsg("Recipe Title Can Not Be Empty")
            return;
        }
        if (recipeIngrd.trim() === "") {
            setErrorMsg("Recipe Ingredients Can Not Be Empty")
            return;
        }
        if (recipeDesc.trim() === "") {
            setErrorMsg("Recipe Details Can Not Be Empty")
            return;
        }
        const recipe = {
            recipeTitle: recipeTitle.trim(),
            recipeIngrd: recipeIngrd.trim(),
            recipeDesc: recipeDesc.trim()

        }

        axios.put("https://ddsbbackend.herokuapp.com/recipes/" + id, recipe)
            .then(res => {
                console.log("Recipe has been added")
                console.log(res.data);
                navigate("/listrecipe")
            }).catch(error => {
                console.log(error)
            })


        console.log({ recipeTitle, recipeIngrd, recipeDesc });
    }






    return (
        <div className="container text-right"><p className='text-danger'>
            {errorMsg}
        </p><form>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlInput1">Recipe Title</label>
                    <input type="text" className="form-control" value={recipeTitle} onChange={(e) => { setRecipeTitle(e.target.value) }} />
                </div>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlTextarea1">Ingredients List</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3" value={recipeIngrd} onChange={(e) => { setRecipeIngrd(e.target.value) }}></textarea>
                </div>
                <div className="form-group p-2">
                    <label htmlFor="exampleFormControlTextarea1">Description</label>
                    <textarea className="form-control" id="exampleFormControlTextarea1" rows="3" value={recipeDesc} onChange={(e) => { setRecipeDesc(e.target.value) }}></textarea>
                </div>
                <button type="button" className="btn btn-dark m-2" onClick={handleSubmit}>Update Your Recipe</button>
            </form></div>
    )
}
