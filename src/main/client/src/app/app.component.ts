import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Monster } from './monster';
import { MonsterService } from './monster.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  
  public title = 'Monsters';

  constructor() { }

  ngOnInit() { }

}
