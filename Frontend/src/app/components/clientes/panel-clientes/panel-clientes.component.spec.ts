import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelClientesComponent } from './panel-clientes.component';

describe('PanelClientesComponent', () => {
  let component: PanelClientesComponent;
  let fixture: ComponentFixture<PanelClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PanelClientesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PanelClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
