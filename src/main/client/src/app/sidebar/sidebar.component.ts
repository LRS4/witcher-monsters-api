import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Monster } from '../models/monster';
import { MonsterService } from '../services/monster.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.less']
})
export class SidebarComponent implements OnInit {
  
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
