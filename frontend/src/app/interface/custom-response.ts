export interface CustomResponse {
  timeStamp : Date;
  statusCode : number;
  status : string;
  reason : string;
  message : string;
  developerMessage : string;
  data : any;
  // question mark (?) means that the property is optional
  // so it is possible to have a response without the property
}
