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
  public monsters: Monster[] = [];

  constructor(private monsterService: MonsterService) { }

  ngOnInit() {
    this.getMonsters();
  }

  public getMonsters(): void {
    this.monsterService.getMonsters().subscribe(
      (response: Monster[]) => {
        this.monsters = response;
      }
    ),
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
  }
}
