import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import * as mail from '@sendgrid/mail';
import baserUrl from 'src/app/services/helper';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.scss']
})
export class SendEmailComponent {

  subject: String;
  text: string;
  recipients: string;

  urlN : string = baserUrl;

  constructor(private http: HttpClient){}

  sendEmail(){

    const url = 'http://localhost:8084/mails/sendMasiveMails';
    const headers = new HttpHeaders({'Content-Type' : 'application/json'});
    const body = {subject : this.subject, text : this.text, recipients: this.recipients};

    this.http.post(url,body ,{headers}).subscribe(
      response =>{
        console.log(response);
      },
      error =>{
        console.log(error);
      }
    );
  }

}
