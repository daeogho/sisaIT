import { Bar } from "react-chartjs-2";
import { BarChart } from "./Chart/BarChart";
import { PieChart } from "./Chart/PieChart";
import { BubbleChart } from "./Chart/BubbleChart";

function Chartjs(){

        return(
                <div className="container">
                        <h3 style={{color:'white'}}>막대그래프</h3>
                        <div style={{background:"white"}}>
                        <BarChart></BarChart>
                        </div>
                        <h3 style={{color:'white'}}>원그래프</h3>
                        <div style={{background:"white"}}>
                        <PieChart></PieChart>
                        </div>
                        <h3 style={{color:'white'}}>버블그래프</h3>
                        <div style={{background:"white"}}>
                        <BubbleChart></BubbleChart>
                        </div>
                </div>

        ) 

}
export default Chartjs;