import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baserUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  urlN : string = baserUrl;

  //Generar Token
  public generateToken(loginData:any){
    return this.http.post(`${this.urlN + '/auth/login'}`, loginData);
  }

  //iniciar sesion y establecer token en el localStorage
  public loginUser(token:any){
    localStorage.setItem('token', token);

  }

  public isLoggedIn(){
    let tokenStr = localStorage.getItem('token');

    if(tokenStr == undefined || tokenStr =='' || tokenStr == null ){
      return false;
    }else{
      return true;
    }
  }

  //cerrar Sesion y elimina el token del localStorage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  //Obtener token 
  public getToken(){
    return localStorage.getItem('token');
  }

  public setUser(user:any){
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(){
    let userStr = localStorage.getItem('user');
    if(userStr != null){
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null;
    }
  }

  public getUserRole(){
    let user = this.getUser();
    if(user != null && user.authorities != null && user.authorities.length > 0){
      return user.authorities[0].authority;
    }else{
      this.logout();
      return null;
    }
  }

 

  
}
