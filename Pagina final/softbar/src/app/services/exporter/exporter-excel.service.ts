import { DatePipe } from '@angular/common';
import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';


const EXCEL_TYPE=
'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8';

const EXCEL_EXT = '.xlsx'


@Injectable({
  providedIn: 'root'
})
export class ExporterExcelService {

  constructor() { }

  exportToExcel(json, excelFileName:string):void{

    const workSheet : XLSX.WorkSheet= XLSX.utils.json_to_sheet(json);
    const workBook: XLSX.WorkBook= {Sheets:{ 'data': workSheet},
    SheetNames:['data']
  };

  const excelBuffer: any = XLSX.write(workBook,{bookType: 'xlsx', type:'array'});
  //llamar al metodo buffer y el filename
  this.saveAsExcel(excelBuffer, excelFileName)
  }


  private saveAsExcel(buffer:any, filename:string) : void{
    const data: Blob = new Blob([buffer], {type:EXCEL_TYPE});
    FileSaver.saveAs(data, filename + '_export_' + EXCEL_EXT);
  }




}
